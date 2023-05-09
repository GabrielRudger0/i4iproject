package ProjectObject;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FuncoesUtil extends PlainDocument {
    private int limite;

    public FuncoesUtil(int limite) {
        super();
        this.limite = limite;
    }

    public void insertString(int offset, String str, AttributeSet attr)
            throws BadLocationException {
        if (str == null) {
            return;
        }

        if ((getLength() + str.length()) <= limite) {
            super.insertString(offset, str, attr);
        }
    }
    public static String formatarData(String data) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dataFormatada = "";
        try {
            Date dataNaoFormata = formato.parse(data);


        SimpleDateFormat formatoBrasil = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        dataFormatada = formatoBrasil.format(dataNaoFormata);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dataFormatada;
    }
}






