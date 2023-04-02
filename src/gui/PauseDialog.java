package gui;

import objects.Size;

public class PauseDialog extends Dialog{
    public PauseDialog(String text) {
        super(text);
    }

    public PauseDialog(String title, String text, Size size, Button[] actions) {
        super(title, text, size);
    }
}
