package stan.presenter.mafia.core.player;

import stan.presenter.mafia.core.MafiaDescription;
import stan.presenter.mafia.core.role.Role;

public class Player
        extends MafiaDescription
{
    public Role role;
    public Tries tries;
    public Properties prop;
    public boolean bot;//бот или нет

    public Player(String n, String d)
    {
        super(n, d);
    }

    public void clear()
    {
        tries.clear();
    }
    public void clearAll()
    {
        clear();
        if(role!=null)
        {
            if(role.actions!=null)
            {
                for(int i = 0; i < role.actions.length; i++)
                {
                    if(role.actions[i]!=null)
                    {
                        role.actions[i].clear();
                    }
                }
            }
        }
    }
}