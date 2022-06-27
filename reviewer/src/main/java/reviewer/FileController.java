package reviewer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Controller
public class FileController {
    @Autowired
    private Environment env;

    @GetMapping(value = "/")
    public String directory(Model model, @RequestParam(value = "path", required = false) String path, @RequestParam(value = "next", required = false) String next) {
        String root= env.getProperty("root",String.class);
        //Определили путь, который нам нужен
        if (path == null || "null".equalsIgnoreCase(path))  {
            path = root + File.separator;
        }
        if (next != null) {
            path += next + File.separator;
        }

        //Проверили, что путь существует и что путь ведёт к директории, а не файлу
        File dir = new File(path);
        if (!dir.exists() || !dir.isDirectory()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
        //Получаем все файлы
        File[] files = dir.listFiles();
        if (files == null) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }

        //Преобразуем в наш формат
        List<FileModel> visible = new ArrayList<>();
        for (File file : files) {
            visible.add(new FileModel(file));
        }

        if (dir.getParent()!=null) {
            //Путь к предыдущей директории
            model.addAttribute("prev", dir.getParent() + File.separator);
        }
        //Текущая папка
        model.addAttribute("dir", path);
        //Список файлов
        model.addAttribute("files", visible);

        return "home";
    }
}
