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
        this.customizeRole = v.findViewById(R.id.customizeRole);
        this.deleteRole = v.findViewById(R.id.deleteRole);
        this.lableRole = (TextView)v.findViewById(R.id.lableRole);
        this.infoRole = v.findViewById(R.id.infoRole);
        this.descriptionRole = (TextView)v.findViewById(R.id.descriptionRole);
    }

    public void hide()
    {
        this.infoRole.setVisibility(View.GONE);
        this.deleteRole.setVisibility(View.GONE);
        this.customizeRole.setVisibility(View.GONE);
    }
    public void show()
    {
        this.infoRole.setVisibility(View.VISIBLE);
        this.deleteRole.setVisibility(View.VISIBLE);
        this.customizeRole.setVisibility(View.VISIBLE);
    }
}