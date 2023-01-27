import { product } from "./product";

export class ProductOrder {
    product: product;
    quantity: number;

    constructor(product: product, quantity: number) {
        this.product = product;
        this.quantity = quantity;
    }
}