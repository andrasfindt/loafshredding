package xyz.andrasfindt.loafshredding;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class Block {
    private final List<Suburb> suburbs = new ArrayList<>();

    public List<Suburb> getSuburbs() {
        return suburbs;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
