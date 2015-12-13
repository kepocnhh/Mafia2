package stan.presenter.mafia.core.abilities.active.changeProperty;

import stan.presenter.mafia.core.player.Player;

public class HealNight
        extends ChangeProperty
{
    public HealNight(String n, String d)
    {
        super(n, d);
    }

    @Override
    public int[] getMap()
    {
        int[] map = new int[3];
        map[0] = TypeAbility.Active.ordinal();
        map[1] = TypeActive.ChangeProperty.ordinal();
        map[2] = TypeChangeProperty.HealNight.ordinal();
        return map;
    }

    @Override
    public Player engage(Player p)
    {
        p.prop.heal_night = true;
        return p;
    }
}