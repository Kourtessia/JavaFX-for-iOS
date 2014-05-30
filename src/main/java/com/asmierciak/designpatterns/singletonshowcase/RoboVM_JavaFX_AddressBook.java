package com.asmierciak.designpatterns.singletonshowcase;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


import com.asmierciak.designpatterns.singletonshowcase.logic.AddressBook;
import com.asmierciak.designpatterns.singletonshowcase.logic.AddressBookItem;

public class RoboVM_JavaFX_AddressBook extends Application {



    private TableView<AddressBookItem> table = new TableView<AddressBookItem>();

    public static void main(final String[] args) throws Exception {
        launch(args);
    }

    @Override
    public final void start(final Stage stage) throws Exception {
        Scene scene = new Scene(new Group());
        stage.setTitle("Address Book JavaFX");

        final Label label = new Label("Address Book");
        label.setFont(new Font("Arial", 20));

        initializeAddressBookView(table);
        BorderPane layout = createMainWindowLayout(label, table);

        ((Group) scene.getRoot()).getChildren().addAll(layout);

        stage.setScene(scene);
        stage.show();
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private static void addAddressBookColumns(TableView<AddressBookItem> table) {
        TableColumn firstNameColumn = new TableColumn("First Name");
        firstNameColumn.setMinWidth(80);
        firstNameColumn
                .setCellValueFactory(new PropertyValueFactory<AddressBookItem, String>(
                        "firstName"));
        firstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        firstNameColumn
                .setOnEditCommit(new EventHandler<CellEditEvent<AddressBookItem, String>>() {
                	public void handle(
                            final CellEditEvent<AddressBookItem, String> t) {
                        t.getTableView().getItems()
                                .get(t.getTablePosition().getRow())
                                .setFirstName(t.getNewValue());
                    }
                });

        TableColumn lastNameColumn = new TableColumn("Last Name");
        lastNameColumn.setMinWidth(80);
        lastNameColumn
                .setCellValueFactory(new PropertyValueFactory<AddressBookItem, String>(
                        "lastName"));
        lastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        lastNameColumn
                .setOnEditCommit(new EventHandler<CellEditEvent<AddressBookItem, String>>() {
                    public void handle(
                            final CellEditEvent<AddressBookItem, String> t) {
                        t.getTableView().getItems()
                                .get(t.getTablePosition().getRow())
                                .setLastName(t.getNewValue());
                    }
                });

        TableColumn fullAddressColumn = new TableColumn("Full address");
        fullAddressColumn.setMinWidth(40);
        fullAddressColumn
                .setCellValueFactory(new PropertyValueFactory<AddressBookItem, String>(
                        "fullAddress"));
        fullAddressColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        fullAddressColumn
                .setOnEditCommit(new EventHandler<CellEditEvent<AddressBookItem, String>>() {
                    public void handle(CellEditEvent<AddressBookItem, String> t) {
                        t.getTableView().getItems()
                                .get(t.getTablePosition().getRow())
                                .setFullAddress(t.getNewValue());
                    }
                });

  
        table.getColumns().addAll(firstNameColumn, lastNameColumn, fullAddressColumn);
              //  fullAddressColumn, phoneNumberColumn, emailAddressColumn);
       // log.debug("Added all collumns successfully");
    }

    private void initializeAddressBookView(
            final TableView<AddressBookItem> addressBookView) {
        //addressBookView.setEditable(true);
        addAddressBookColumns(addressBookView);

        populateAddressBook();
       addressBookView.setItems(AddressBook.getInstance()
                .getObservableAddresses());

        //log.debug("Initialized table view successfully");
       //Stax loads the woodstox driver using reflection. RobmVM strips out classes not reachable from your mainClass. So you need to tell it to include the driver. Try adding 
       //<forceLinkClasses>com.ctc.wstx.stax.WstxInputFactory</forceLinkClasses>
      // To your robovm.xml or to the robovm plugin config in your pom.xml.
    }

    private static BorderPane createMainWindowLayout(
            final Label mainWindowHeading,
            final TableView<AddressBookItem> addressBookView) {
        final BorderPane layout = new BorderPane();
        layout.setTop(mainWindowHeading);
        layout.setCenter(addressBookView);
        layout.setBottom(createNewContactBox());
        //layout.setRight(createOptionsBox());

        layout.setPadding(new Insets(10, 0, 0, 10));
        return layout;
    }

    private static HBox createNewContactBox() {
        HBox buttonsBar = new HBox();
        buttonsBar.setSpacing(3);

        final TextField addFirstName = new TextField();
        addFirstName.setPromptText("First name");
        addFirstName.setPrefWidth(80);

        final TextField addLastName = new TextField();
        addLastName.setPromptText("Last name");
        addLastName.setPrefWidth(80);

        final TextField addFullAddress = new TextField();
        addFullAddress.setPromptText("Full address");
        addFullAddress.setPrefWidth(80);

        Button addContact = new Button("Add");
        addContact.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(final ActionEvent e) {
                AddressBook.getInstance().addAddress(
                        new AddressBookItem(addFirstName.getText(), addLastName
                                .getText(), addFullAddress.getText()
                                ));
                addFirstName.clear();
                addLastName.clear();
                addFullAddress.clear();
            }
        });

        buttonsBar.getChildren().addAll(addFirstName, addLastName,
                addFullAddress, addContact);
        return buttonsBar;
    }

    private void populateAddressBook() {
        AddressBook.getInstance().addAddress(
                new AddressBookItem("Jacob", "Smith", "NY City"));
        AddressBook.getInstance().addAddress(
                new AddressBookItem("Isabella", "Johnson", "Warsaw"));
        AddressBook.getInstance().addAddress(
                new AddressBookItem("Ethan", "Williams", "NY City"));
        AddressBook.getInstance().addAddress(
                new AddressBookItem("Emma", "Jones", "Sendlinger Tor Platz 10"));
        AddressBook.getInstance().addAddress(
                new AddressBookItem("Michael", "Brown", "Cracow"));
    }
}
