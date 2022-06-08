interface WithId {
    Long getId();
}

public class Friend implements WithId {
    private static long lastId = 1;
    private Long id;
    void Enemy() {
        id = lastId++;
    }
    @Override
    public Long getId() {
        return id;
    }
}
