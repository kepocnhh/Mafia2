package stan.presenter.mafia.ui.adapters.constructor.menu;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import stan.presenter.mafia.R;
import stan.presenter.mafia.listeners.adapters.constructor.menu.IActionListListener;
import stan.presenter.mafia.ui.adapters.StanRecyclerAdapter;
import stan.presenter.mafia.ui.holders.adapters.constructor.menu.ActionListRecyclerHolder;

public class ActionListRecyclerAdapter
        extends StanRecyclerAdapter
{
    IActionListListener listener;
    private int checkPosition = -1;

    public ActionListRecyclerAdapter(Context context, IActionListListener l)
    {
        super(context, R.layout.constructor_menu_actionlist_item);
        listener = l;
    }

    @Override
    protected RecyclerView.ViewHolder initHolder(View v)
    {
        return new ActionListRecyclerHolder(v);
    }

    @Override
    protected void initView(RecyclerView.ViewHolder h, int i)
    {

    }

    protected void pressItem(int p)
    {
        if(checkPosition == p)
        {
            checkPosition = -1;
        }
        else
        {
            checkPosition = p;
        }
        notifyDataSetChanged();
    }

    ActionListRecyclerHolder getHolder(RecyclerView.ViewHolder holder)
    {
        return (ActionListRecyclerHolder) holder;
    }
}