package stan.presenter.mafia.core.action;

import stan.presenter.mafia.core.MafiaDescription;
import stan.presenter.mafia.core.abilities.Ability;

public class Action
        extends MafiaDescription
{
    public Ability[] abilities;//

    public int to;
    public int from;

    public Action(String n, String d)
    {
        super(n, d);
    }

    public void clear()
    {
    }
}