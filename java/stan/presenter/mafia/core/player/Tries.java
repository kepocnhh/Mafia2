package stan.presenter.mafia.core.player;

import java.util.ArrayList;
import java.util.List;

public class Tries
{
    private class Leverage
    {
        public int who;
        public Properties how;

        public Leverage(int w, Properties h)
        {
            this.who = w;
            this.how = h;
        }
    }

    public List<Leverage> leverages;

    public void clear()
    {
        leverages = new ArrayList<>();
    }
    public void add(int w, Properties h)
    {
        leverages.add(new Leverage(w,h));
    }

    public Tries()
    {
        clear();
    }
}