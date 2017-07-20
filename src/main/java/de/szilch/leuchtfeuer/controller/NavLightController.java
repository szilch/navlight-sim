package de.szilch.leuchtfeuer.controller;

import de.szilch.leuchtfeuer.logic.NavLightExecutor;
import de.szilch.leuchtfeuer.model.api.NavLight;
import de.szilch.leuchtfeuer.model.api.NavLightColor;
import de.szilch.leuchtfeuer.model.api.NavLightType;
import de.szilch.leuchtfeuer.util.ResourceUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

/**
 * Controller for Frontend!
 */
public class NavLightController {

    @FXML
    private Circle fire;

    @FXML
    private ComboBox<NavLightType> cboNavLightTypes;
    @FXML
    private ComboBox<NavLightColor> cboColors;
    @FXML
    private Slider sdrGroups;
    @FXML
    private Slider sdrRecurrences;
    @FXML
    private Label lblRecurrence;
    @FXML
    private ToggleButton tglStartStop;

    private NavLightExecutor executor;
    private NavLight navLight;

    private void simulate() {
        if (executor != null) {
            executor.cancel();
            fire.setVisible(false);
        }
        if (tglStartStop.isSelected()) {
            navLight = new NavLight.Builder(cboNavLightTypes.getSelectionModel()
                    .getSelectedItem())
                    .color(cboColors.getSelectionModel().getSelectedItem())
                    .recurrence((int) sdrRecurrences.getValue())
                    .groups((int) sdrGroups.getValue())
                    .build();

            executor = new NavLightExecutor(fire, navLight);
            setMinimalRecurrence();
        }
    }

    @FXML
    public void initialize() {
        ObservableList<NavLightType> obList = FXCollections.observableList(Arrays.asList(NavLightType.values()));
        cboNavLightTypes.getItems().clear();
        cboNavLightTypes.setItems(obList);
        cboNavLightTypes.getSelectionModel().selectFirst();
        cboNavLightTypes.valueProperty().addListener((observable, oldValue, newValue) -> {
            sdrGroups.setDisable(!newValue.hasGroups());
            sdrRecurrences.setDisable(!newValue.hasRecurrence());
            sdrGroups.setValue(0);
            sdrRecurrences.setMin(0);
            sdrRecurrences.setValue(0);
            simulate();
        });

        ObservableList<NavLightColor> obColorList = FXCollections.observableList(Arrays.asList(NavLightColor.values()));
        cboColors.getItems().clear();
        cboColors.setItems(obColorList);
        cboColors.getSelectionModel().selectLast();
        cboColors.valueProperty().addListener((observable, oldValue, newValue) -> simulate());

        sdrGroups.valueProperty().addListener((observable, oldValue, newValue) -> simulate());

        updateRecurrenceLabel();
        sdrRecurrences.valueProperty().addListener((observable, oldValue, newValue) -> {
            updateRecurrenceLabel();
            simulate();
        });
        tglStartStop.selectedProperty().addListener((observable, oldValue, newValue) -> simulate());
    }

    private void setMinimalRecurrence() {
        long minimal = navLight.getMinimumRecurrenceInSec();
        if (minimal > 0 && sdrRecurrences.getValue() < minimal && !sdrRecurrences.isDisable()) {
            sdrRecurrences.setValue(minimal);
        }
        updateRecurrenceLabel();
    }

    private void updateRecurrenceLabel() {
        long value = (long) sdrRecurrences.getValue();
        lblRecurrence.setText(ResourceUtils.getInstance().getString("toolbar.label.recurrence", value));
    }
}
