package stan.presenter.mafia.core.abilities.active.changeProperty;

import org.json.JSONArray;

import stan.presenter.mafia.core.player.Player;

public class Kill
        extends ChangeProperty
{
    public Kill(String n, String d)
    {
        super(n, d);
    }

    @Override
    public JSONArray getMap()
    {
        JSONArray abilitieArray = new JSONArray();
        abilitieArray.put(TypeAbility.Active.ordinal());
        abilitieArray.put(TypeActive.ChangeProperty.ordinal());
        abilitieArray.put(TypeChangeProperty.Kill.ordinal());
        return abilitieArray;
    }

    @Override
    public Player engage(Player p)
    {
        p.prop.life = false;
        return p;
    }
}