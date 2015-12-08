package stan.presenter.mafia.core.abilities;

import stan.presenter.mafia.core.MafiaDescription;

public abstract class Ability
        extends MafiaDescription
{
    public enum TypeAbility
    {
        Active,
        CheckTwoPlayers,
        Now,
        Passive
    }

    public Ability(String n, String d)
    {
        super(n, d);
    }

    public abstract int[] getMap();
}