package ProjectObject;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class LimitadorCaracteres extends PlainDocument {
    private int limite;

    public LimitadorCaracteres(int limite) {
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
}






