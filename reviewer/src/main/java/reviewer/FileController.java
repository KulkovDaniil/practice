package reviewer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FileController {

    @GetMapping(value = "/")
    public String directory(Model model) {
        File dir = new File("C:");
        List<reviewer.Files> list = new ArrayList<>();
        for (File file : dir.listFiles()) {
            list.add(new reviewer.Files(file.getName(), file.isDirectory()));
        }

        model.addAttribute("slash", "/");
        model.addAttribute("link", "C:");
        model.addAttribute("isEmpty", list.isEmpty());
        model.addAttribute("files", list);

        return "home";
    }

    @GetMapping(value = "forward")
    public String forward(@RequestParam(value = "path") String path, Model model) {

        File dir = new File(path);
        List<reviewer.Files> list = new ArrayList<>();
        for (File file : dir.listFiles()) {
            list.add(new reviewer.Files(file.getName(), file.isDirectory()));
        }

        model.addAttribute("slash", "/");
        model.addAttribute("link", path);
        model.addAttribute("isEmpty", list.isEmpty());
        model.addAttribute("files", list);

        return "home";
    }

    @GetMapping(value = "back")
    public String back(@RequestParam(value = "path") String path, Model model) {

        String[] pathArr = path.split("/");
        String link = pathArr[0];
        for (int i=1; i<pathArr.length-1; i++) {
            link += "/" + pathArr[i];
        }

        File dir = new File(link);
        List<reviewer.Files> list = new ArrayList<>();
        for (File file : dir.listFiles()) {
            list.add(new reviewer.Files(file.getName(), file.isDirectory()));
        }

        model.addAttribute("slash", "/");
        model.addAttribute("link", link);
        model.addAttribute("isEmpty", list.isEmpty());
        model.addAttribute("files", list);

        return "home";
    }
}
