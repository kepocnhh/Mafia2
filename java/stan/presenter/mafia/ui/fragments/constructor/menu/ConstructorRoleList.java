package stan.presenter.mafia.ui.fragments.constructor.menu;

import android.database.Cursor;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import stan.presenter.mafia.R;
import stan.presenter.mafia.database.SQliteApi;
import stan.presenter.mafia.listeners.adapters.constructor.menu.IRoleListListener;
import stan.presenter.mafia.listeners.fragments.constructor.menu.IConstructorRoleClick;
import stan.presenter.mafia.ui.adapters.constructor.menu.RoleListRecyclerAdapter;
import stan.presenter.mafia.ui.fragments.StanFragment;

public class ConstructorRoleList
        extends StanFragment
    implements IRoleListListener
{
    //_______________VIEWS
    private RecyclerView listRoles;

    //_______________FIELDS
    private RoleListRecyclerAdapter adapter;

    static public ConstructorRoleList newInstance()
    {
        return new ConstructorRoleList();
    }

    public ConstructorRoleList()
    {
        super(R.layout.constructor_role_list, R.string.ConstructorRoleList);
    }

    @Override
    protected void findViews(View v)
    {
        super.findViews(v);
        listRoles = (RecyclerView) v.findViewById(R.id.listRoles);
        initList();
        init();
    }
    private void initList()
    {
        adapter = new RoleListRecyclerAdapter(getActivity(), this);
        listRoles.setLayoutManager(new LinearLayoutManager(getActivity()));
        listRoles.setAdapter(adapter);
    }
    private void init()
    {
        adapter.swapCursor(SQliteApi.getRoles());
    }

    private IConstructorRoleClick getClickListener()
    {
        return (IConstructorRoleClick) clickListener;
    }

    @Override
    public void customizeRole(int id)
    {

    }

    @Override
    public void deleteRole(int id)
    {

    }
}