package jnitTest;

import java.util.Objects;

public class RealTestCase {
    private String id;

    public RealTestCase(String id) {
        this.id = id;
    }

    public RealTestCase() {
        this.id = "test";
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RealTestCase that = (RealTestCase) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
