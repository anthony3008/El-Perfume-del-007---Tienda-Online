package com.perfumeshop.model;

public class CartItem {
    private Perfume perfume;
    private int quantity;

    public CartItem() {}

    public CartItem(Perfume perfume, int quantity) {
        this.perfume = perfume;
        this.quantity = quantity;
    }

    // Getters y Setters
    public Perfume getPerfume() { return perfume; }
    public void setPerfume(Perfume perfume) { this.perfume = perfume; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getTotal() {
        return perfume.getPrecio() * quantity;
    }
}