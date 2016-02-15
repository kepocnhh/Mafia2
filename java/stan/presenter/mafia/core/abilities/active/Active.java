package stan.presenter.mafia.core.abilities.active;

import stan.presenter.mafia.core.abilities.Ability;

public abstract class Active
        extends Ability
{
    public Active(String n, String d)
    {
        super(n, d);
    }

    public enum TypeActive
    {
        ChangeProperty,
        NotifyTown
    }
}