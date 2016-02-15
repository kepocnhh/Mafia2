package stan.presenter.mafia.ui.adapters.constructor.menu;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import stan.presenter.mafia.R;
import stan.presenter.mafia.database.Tables;
import stan.presenter.mafia.listeners.adapters.constructor.menu.IRoleListListener;
import stan.presenter.mafia.ui.adapters.StanRecyclerAdapter;
import stan.presenter.mafia.ui.holders.adapters.constructor.menu.RoleListRecyclerHolder;

public class RoleListRecyclerAdapter
        extends StanRecyclerAdapter
{
    IRoleListListener listener;
    private int checkPosition = -1;

    public RoleListRecyclerAdapter(Context context, IRoleListListener l)
    {
        super(context, R.layout.constructor_menu_rolelist_item);
        listener = l;
    }

    @Override
    protected RecyclerView.ViewHolder initHolder(View v)
    {
        return new RoleListRecyclerHolder(v);
    }

    @Override
    protected void initView(RecyclerView.ViewHolder h, final int i)
    {
        h.itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                pressItem(i);
            }
        });
        getHolder(h).lableRole.setText(mCursor.getString(mCursor.getColumnIndex(Tables.NAME)));
        if(checkPosition != i)
        {
            getHolder(h).hide();
            return;
        }
        getHolder(h).show();
        getHolder(h).infoRole.setVisibility(View.VISIBLE);
        getHolder(h).descriptionRole.setText(mCursor.getString(mCursor.getColumnIndex(Tables.DESCRIPTION)));
        getHolder(h).customizeRole.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                listener.customizeRole((int)getItemId(i));
            }
        });
        getHolder(h).deleteRole.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                listener.deleteRole((int)getItemId(i));
            }
        });
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

    RoleListRecyclerHolder getHolder(RecyclerView.ViewHolder holder)
    {
        return (RoleListRecyclerHolder) holder;
    }
}