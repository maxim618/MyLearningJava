package Experience;

public class TypeFiltration {
    protected Filtering filtering;
    public TypeFiltration(Filtering filtering){
        this.filtering = filtering;
    }
    public Filtering doIt(){
        return filtering;
    }
}
