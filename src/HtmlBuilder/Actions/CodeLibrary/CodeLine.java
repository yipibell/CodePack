package HtmlBuilder.Actions.CodeLibrary;

public class CodeLine {
    private String Part;
    private String Code;

    public CodeLine(String part, String code) {
        this.Part = part;
        this.Code = code;
    }

    public String getPart() {
        return Part;
    }

    public void setPart(String part) {
        Part = part;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }
}
