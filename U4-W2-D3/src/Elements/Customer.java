package Elements;

import java.util.Random;

public class Customer {

    private Long id;
    private String name;
    private Integer tier;

    public Customer(String name, Integer tier) {
        Random randomIdCos = new Random();
        this.id = randomIdCos.nextLong();
        this.name = name;
        this.tier = tier;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTier() {
        return tier;
    }

    public void setTier(Integer tier) {
        this.tier = tier;
    }
}
