package application;

import java.io.IOException;

import javafx.application.Platform;
import javafx.scene.control.ComboBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Options extends ComboBox<String> {

	public Options() {

		setPromptText("Options");
		getItems().addAll("Options", "Create CSV", "Add Photo's");

		setEditable(false);

		setOnAction(e -> {

			getChoice(getValue());
		});
	}

	public void getChoice(String choice) {

		if (choice == "Create CSV") {

			try {
				new IO().saveCSV(Table.date, Table.location, Table.trailName, Table.miles, Table.subentries);
			} catch (IOException e1) {

				e1.printStackTrace();
			}

			Platform.runLater(() -> getSelectionModel().select(0));

		} 

		else if (choice == "Add Photo's") {

			new ImageExplorer();

			Platform.runLater(() -> getSelectionModel().select(0));

		}
	}

}
