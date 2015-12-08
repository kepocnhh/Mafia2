package stan.presenter.mafia.core.abilities.active.changeProperty;

import stan.presenter.mafia.core.abilities.active.Active;
import stan.presenter.mafia.core.player.Player;

public abstract class ChangeProperty
        extends Active
{
    public ChangeProperty(String n, String d)
    {
        super(n, d);
    }

    public enum TypeChangeProperty
    {
        Kill,
        HealDay,
        HealNight,
        Block
    }

    public abstract Player engage(Player p);
}