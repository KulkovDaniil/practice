public class Enemy implements WithId {
    private static long lastId = -1;
    private Long id;

    Enemy() {
        id = lastId--;
    }

    @Override
    public Long getId() {
        return id;
    }
}
