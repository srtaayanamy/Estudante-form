package interfaceGrafica;

import java.net.URL;
import java.util.ResourceBundle;
import entidades.Estudante;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

public class EstudanteFXMLController implements Initializable {

    @FXML private TextField txtNome;
    @FXML private TextField txtIdade;
    @FXML private TextField txtMatricula;
    @FXML private TextField txtNota;
    @FXML private Button btnCalcular;
    @FXML private Button btnLimpar;
    @FXML private Label lblResultado;
    @FXML private Label lblNotaFinal;
    @FXML private RadioButton rdoManha;
    @FXML private RadioButton rdoTarde;
    @FXML private RadioButton rdoNoite;
    @FXML private ComboBox<String> cboFuncao;

    public void onBtnCalcularClick() {
        String nome = txtNome.getText();
        double nota;

        // Validação de entrada
        try {
            nota = Double.parseDouble(txtNota.getText());
        } catch (NumberFormatException e) {
            lblResultado.setText("Por favor, insira uma nota válida.");
            return;
        }

        // Calculando a nota final
        String funcao = cboFuncao.getValue();
        Estudante estudante = new Estudante(nome);
        double notaFinal = estudante.somaPontos(nota, funcao);

        // Determinar resultado
        String resultado = notaFinal >= 6.0 ? "Aprovado" : "Reprovado";
        lblResultado.setText(resultado);

        // Atualizar nota final na interface
        lblNotaFinal.setText(String.format("Nota Final: %.2f", notaFinal));

        btnCalcular.setDisable(true);
    }

    public void onBtnLimparClick() {
        txtNome.clear();
        txtIdade.clear();
        txtMatricula.clear();
        txtNota.clear();
        lblResultado.setText("");
        lblNotaFinal.setText("");
        btnLimpar.setDisable(true);
    }

    public void onKeyreleased() {
        boolean calcular = txtNota.getText().isEmpty() || txtNome.getText().isEmpty();
        btnCalcular.setDisable(calcular);

        boolean limpar = txtNome.getText().isEmpty() && txtIdade.getText().isEmpty() && txtMatricula.getText().isEmpty() && txtNota.getText().isEmpty();
        btnLimpar.setDisable(limpar);
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        cboFuncao.getItems().addAll("Gremista", "Esportista", "Leitor", "Nenhum deles");
        btnCalcular.setDisable(true);
        btnLimpar.setDisable(true);
    }
} 