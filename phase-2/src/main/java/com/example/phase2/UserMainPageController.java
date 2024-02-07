package com.example.phase2;

import com.example.phase2.Model.Product.Category;
import com.example.phase2.Model.Product.Product;
import com.example.phase2.Model.Product.ProductInfo.Comment;
import com.example.phase2.Model.Product.ProductInfo.Factor;
import com.example.phase2.Model.Product.ProductInfo.Request;
import com.example.phase2.Model.User.Admin;
import com.example.phase2.Model.User.Shopper;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import java.util.Timer;

public class UserMainPageController implements Initializable {
    @FXML
    private Label soonDelivery_ID;
    @FXML
    private ImageView carImage_Id;
    @FXML
    private TextField countOfBuying;
    @FXML
    private CheckBox stationeryFiltering;

    @FXML
    private CheckBox stockFiltering;
    @FXML
    private CheckBox priceFiltering;

    @FXML
    private CheckBox digitalFiltering;

    @FXML
    private CheckBox foodFiltering;
    @FXML
    private CheckBox carFiltering;

    @FXML
    private CheckBox categoryFiltering;

    @FXML
    private TextField mini;

    @FXML
    private TextField maxi;

    @FXML
    private TextField searchedProduct;
    @FXML
    private TextField comment_Id;
    @FXML
    private ListView<Comment> comments_view;
    @FXML
    private Label property_ID;
    @FXML
    private ListView<Product> listView_ID;
    @FXML
    private Label UserName_ID;
    @FXML
    private Label telephone_ID;
    @FXML
    private TextArea showProduct;
    @FXML
    private ImageView charge_ID;
    @FXML
    private TextField scoreField;
    @FXML
    private Slider scoreSlider;

    private static Shopper shopper;


    public static void setShopper(Shopper shopper) {
        UserMainPageController.shopper = shopper;
    }

    public static Shopper getShopper() {
        return shopper;
    }

    @FXML
    void select_Item(MouseEvent event) {
        if (this.listView_ID.getSelectionModel().getSelectionMode() != null) {
            this.showProduct.setText(this.listView_ID.getSelectionModel().getSelectedItem().toString());
            ObservableList<Comment> comments = FXCollections.observableArrayList(this.listView_ID.getSelectionModel().getSelectedItem().getComments());
            this.comments_view.setItems(comments);
        }
    }

    @FXML
    void changeAccountDetails(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ChangeAccountDetailController.class.getResource("editPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 703, 589);
        Stage stage = new Stage();
        stage.setScene(scene);
        ((Stage) this.telephone_ID.getScene().getWindow()).close();
        stage.show();
    }

    @FXML
    void chargeProperty(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ChargeController.class.getResource("ChargeProperty.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 433);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void exitAction(ActionEvent event) throws IOException {
        ((Stage) this.charge_ID.getScene().getWindow()).close();
        HelloApplication helloApplication = new HelloApplication();
        helloApplication.start(new Stage());
    }

    @FXML
    void chargePropertyEntered(MouseEvent event) {
        this.charge_ID.setStyle("-fx-translate-x: 5px;-fx-translate-y: -5px;");
    }

    @FXML
    void chargePropertyExited(MouseEvent event) {
        this.charge_ID.setStyle("-fx-translate-x: -5px;-fx-translate-y: 5px;");
    }

    @FXML
    void sortingProducts(ActionEvent event) {
        Collections.sort(Admin.getAdmin().getProducts(), Product::compareTo);
        ObservableList<Product> products = FXCollections.observableArrayList(Admin.getAdmin().getProducts());
        this.listView_ID.setItems(products);
    }

    @FXML
    void searching(MouseEvent event) {
        ArrayList<Product> searchedProducts = new ArrayList<>();
        for (int i = 0; i < Admin.getAdmin().getProducts().size(); i++) {
            if (Admin.getAdmin().getProducts().get(i).getNameOfProduct().equals(this.searchedProduct.getText()))
                searchedProducts.add(Admin.getAdmin().getProducts().get(i));
        }
        if (searchedProducts.size() != 0) {
            ObservableList<Product> products = FXCollections.observableArrayList(searchedProducts);
            this.listView_ID.setItems(products);
        }
    }

    @FXML
    void commenting(ActionEvent event) {
        boolean bought = false;
        for (Factor factors : shopper.getFactors())
            for (Product product : factors.getProducts())
                if (this.listView_ID.getSelectionModel().getSelectedItem().getNameOfProduct().equals(product.getNameOfProduct()))
                    bought = true;
        Admin.getAdmin().getRequests().add(new Request(shopper, "comment", listView_ID.getSelectionModel().getSelectedItem(), new Comment(shopper, listView_ID.getSelectionModel().getSelectedItem().getID(), this.comment_Id.getText(), bought)));

    }

    @FXML
    void filtering(ActionEvent event) {
        ArrayList<Product> filteredProducts = new ArrayList<>();
        if (this.stockFiltering.isSelected()) {
            for (Product product : Admin.getAdmin().getProducts())
                if (product.getStock() > 0)
                    filteredProducts.add(product);
        }
        if (this.priceFiltering.isSelected()) {
            for (Product product : Admin.getAdmin().getProducts())
                if (product.getPrice() > Double.parseDouble(this.mini.getText()) && product.getPrice() < Double.parseDouble(this.maxi.getText()))
                    filteredProducts.add(product);
        }
        if (this.categoryFiltering.isSelected()) {
            for (Product product : Admin.getAdmin().getProducts()) {
                if (product.getCategory().equals(Category.DIGITALPRODUCT) && digitalFiltering.isSelected())
                    filteredProducts.add(product);
                else if (product.getCategory().equals(Category.FOOD) && foodFiltering.isSelected())
                    filteredProducts.add(product);
                else if (product.getCategory().equals(Category.STATIONERY) && stationeryFiltering.isSelected())
                    filteredProducts.add(product);
                else if (product.getCategory().equals(Category.VEHICLES) && carFiltering.isSelected())
                    filteredProducts.add(product);
            }
        }
        if (filteredProducts.size() > 0) {
            ObservableList<Product> products = FXCollections.observableArrayList(filteredProducts);
            this.listView_ID.setItems(products);
        }
    }

    @FXML
    void addToBasket(ActionEvent event) {
        if (this.listView_ID.getSelectionModel().getSelectedItem().getStock() > Integer.parseInt(this.countOfBuying.getText())) {
            this.listView_ID.getSelectionModel().getSelectedItem().setCountOfBuying(Integer.parseInt(this.countOfBuying.getText()));
            shopper.getProducts().add(this.listView_ID.getSelectionModel().getSelectedItem());
        }
    }

    @FXML
    void scoring(ActionEvent event) {
        try {

            if (this.listView_ID.getSelectionModel().getSelectedItem().getScoresAverage() != 0)
                this.listView_ID.getSelectionModel().getSelectedItem().setScoresAverage((Double.valueOf(this.listView_ID.getSelectionModel().getSelectedItem().getScoresAverage() + this.scoreField.getText()) / 2));
            else
                this.listView_ID.getSelectionModel().getSelectedItem().setScoresAverage(Double.valueOf(this.scoreField.getText()));
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText("only one time can score");
            alert.show();
        }
    }

    @FXML
    void openCashDesk(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ShoppingPageController.class.getResource("FinishShopping.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 700);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.property_ID.setText(String.valueOf(shopper.getProperty()));
        this.UserName_ID.setText(shopper.getNameOfUser());
        this.telephone_ID.setText(shopper.getPhoneNumber());
        ObservableList<Product> products = FXCollections.observableArrayList(Admin.getAdmin().getProducts());
        listView_ID.setItems(products);
        this.scoreSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            this.scoreField.setText(String.valueOf(this.scoreSlider.getValue()));
        });
        TranslateTransition carTransition = new TranslateTransition(Duration.seconds(5),this.carImage_Id);
        carTransition.setByX(700);
        carTransition.setCycleCount(100);
        carTransition.play();
        Timeline timeline = new Timeline(
                new KeyFrame(carTransition.getCurrentTime(), event -> {
                    this.soonDelivery_ID.setVisible(true);  // show the label
                }),
                new KeyFrame(carTransition.getDuration(), event -> {
                    this.soonDelivery_ID.setVisible(false); // hide the label after 5 seconds
                })
        );
        timeline.setCycleCount(100);
        timeline.play();

    }
}
