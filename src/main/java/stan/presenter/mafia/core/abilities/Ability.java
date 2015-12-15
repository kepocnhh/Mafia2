package stan.presenter.mafia.core.abilities;

import org.json.JSONArray;

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

    public abstract JSONArray getMap();
}