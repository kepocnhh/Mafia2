package stan.presenter.mafia.ui.holders.adapters.constructor.menu;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import stan.presenter.mafia.R;

public class RoleListRecyclerHolder
        extends RecyclerView.ViewHolder
{
    public View customizeRole;
    public View deleteRole;
    public TextView lableRole;
    public View infoRole;
    public TextView descriptionRole;

    public RoleListRecyclerHolder(View v)
    {
        super(v);
        customizeRole = v.findViewById(R.id.customizeRole);
        deleteRole = v.findViewById(R.id.deleteRole);
        lableRole = (TextView)v.findViewById(R.id.lableRole);
        infoRole = v.findViewById(R.id.infoRole);
        descriptionRole = (TextView)v.findViewById(R.id.descriptionRole);
    }
}