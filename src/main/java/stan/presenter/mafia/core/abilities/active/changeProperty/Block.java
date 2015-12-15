package stan.presenter.mafia.core.abilities.active.changeProperty;

import org.json.JSONArray;

import stan.presenter.mafia.core.player.Player;

public class Block
        extends ChangeProperty
{
    public Block(String n, String d)
    {
        super(n, d);
    }

    @Override
    public JSONArray getMap()
    {
        JSONArray abilitieArray = new JSONArray();
        abilitieArray.put(TypeAbility.Active.ordinal());
        abilitieArray.put(TypeActive.ChangeProperty.ordinal());
        abilitieArray.put(TypeChangeProperty.Block.ordinal());
        return abilitieArray;
    }

    @Override
    public Player engage(Player p)
    {
        p.prop.stop = true;
        return p;
    }
}