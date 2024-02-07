package com.example.phase2;

import com.example.phase2.Exception.LowPropertyException;
import com.example.phase2.Exception.NotEnoughStockException;
import com.example.phase2.Exception.WrongDiscountCodeException;
import com.example.phase2.Model.Product.Discountable;
import com.example.phase2.Model.Product.Product;
import com.example.phase2.Model.Product.ProductInfo.Discount;
import com.example.phase2.Model.User.Shopper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ShoppingPageController implements Initializable {
    private static Shopper shopper;
    private double price = 0;
    private double endedPrice = 0;
    @FXML
    private ListView<Product> basketView;

    @FXML
    private TextField discountCode;

    @FXML
    private ListView<Discount> discountView;

    @FXML
    private Label discountedPrice;


    @FXML
    private Label inventory;

    @FXML
    private Label realPrice;

    @FXML
    void discounting(MouseEvent event) {
        try {
            boolean check = false;
            int discountPercent = 0;
            if (this.discountCode == null)
                throw new WrongDiscountCodeException();
            for (Discount discount : shopper.getDiscountCode()) {
                StringBuilder stringBuilder = new StringBuilder(this.discountCode.getText());
                if (discount.getCodeOfDiscount().compareTo(stringBuilder) == 0 && discount.getCapacity() > 0) {
                    check = true;
                    discountPercent = discount.getDiscountPercent();
                    break;
                }
            }
            if (!check)
                throw new WrongDiscountCodeException();
            else {
                endedPrice = price * ((100.0 - discountPercent) / 100);
                this.discountedPrice.setText(String.valueOf(endedPrice));
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.show();
            }
        } catch (WrongDiscountCodeException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }

    @FXML
    void shopping(ActionEvent event) {
        boolean shop = true;
        try {
            if (shopper.getProperty() < endedPrice)
                throw new LowPropertyException();
        } catch (LowPropertyException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.show();
            shop = false;
        }
        try {
            for (Product product : shopper.getProducts())
                if (product.getStock() == 0)
                    throw new NotEnoughStockException();
        } catch (NotEnoughStockException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.show();
            shop = false;
        }
        if (shop) {
            shopper.setProperty(shopper.getProperty() - endedPrice);
            for (Product product : shopper.getProducts()) {
                product.setStock(product.getStock() - product.getCountOfBuying());
                product.setCountOfBuying(0);
            }
            shopper.getProducts().removeAll(shopper.getProducts());
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("bought successfully");
            alert.show();
            ((Stage) this.discountedPrice.getScene().getWindow()).close();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        shopper = UserMainPageController.getShopper();
        ObservableList<Product> basket = FXCollections.observableArrayList(shopper.getProducts());
        this.basketView.setItems(basket);
        ObservableList<Discount> discounts = FXCollections.observableArrayList(shopper.getDiscountCode());
        this.discountView.setItems(discounts);
        for (Product product : shopper.getProducts()) {
            if (product.getDiscountedPrice() == 0)
                price += product.getCountOfBuying() * product.getPrice();
            else price += product.getCountOfBuying() * product.getDiscountedPrice();
        }
        endedPrice = price;
        this.inventory.setText(String.valueOf(shopper.getProperty()));
        this.realPrice.setText(String.valueOf(price));
        this.discountedPrice.setText(String.valueOf(price));

    }
}
