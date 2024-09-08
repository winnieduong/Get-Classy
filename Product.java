public class Product {
    private String name;
    private String description;
    private String ID;
    private double cost;

    public Product(String name, String description, String ID, double cost) {
        this.name = name;
        this.description = description;
        this.ID = ID;
        this.cost = cost;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getID() { return ID; }
    public double getCost() { return cost; }

    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setCost(double cost) { this.cost = cost; }

    public String productDescription() {
        return name + ": " + description + " - $" + cost;
    }

    public String toCSV() {
        return ID + "," + name + "," + description + "," + cost;
    }

    public String toJSON() {
        return "{ \"ID\": \"" + ID + "\", \"name\": \"" + name + "\", \"description\": \"" + description + "\", \"cost\": " + cost + " }";
    }

    public String toXML() {
        return "<Product><ID>" + ID + "</ID><name>" + name + "</name><description>" + description + "</description><cost>" + cost + "</cost></Product>";
    }

    @Override
    public String toString() {
        return productDescription() + " (ID: " + ID + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Product product = (Product) obj;

        return ID.equals(product.ID);
    }
}
