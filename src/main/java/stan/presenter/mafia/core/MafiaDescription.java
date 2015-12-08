package stan.presenter.mafia.core;

public abstract class MafiaDescription
        extends Mafia
{
    public String description;

    public MafiaDescription(String n, String d)
    {
        super(n);
        this.description = d;
    }
}