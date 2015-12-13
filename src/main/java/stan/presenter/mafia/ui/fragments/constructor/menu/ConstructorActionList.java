package stan.presenter.mafia.ui.fragments.constructor.menu;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import stan.presenter.mafia.R;
import stan.presenter.mafia.database.SQliteApi;
import stan.presenter.mafia.listeners.adapters.constructor.menu.IActionListListener;
import stan.presenter.mafia.listeners.fragments.constructor.menu.IConstructorActionClick;
import stan.presenter.mafia.ui.adapters.constructor.menu.ActionListRecyclerAdapter;
import stan.presenter.mafia.ui.fragments.StanFragment;

public class ConstructorActionList
        extends StanFragment
    implements IActionListListener
{
    //_______________VIEWS
    private RecyclerView listActions;

    //_______________FIELDS
    private ActionListRecyclerAdapter adapter;

    static public ConstructorActionList newInstance()
    {
        return new ConstructorActionList();
    }

    public ConstructorActionList()
    {
        super(R.layout.constructor_action_list, R.string.ConstructorActionList);
    }

    @Override
    protected void findViews(View v)
    {
        super.findViews(v);
        listActions = (RecyclerView) v.findViewById(R.id.listActions);
        initList();
        init();
    }
    private void initList()
    {
        adapter = new ActionListRecyclerAdapter(getActivity(), this);
        listActions.setLayoutManager(new LinearLayoutManager(getActivity()));
        listActions.setAdapter(adapter);
    }
    private void init()
    {
        adapter.swapCursor(SQliteApi.getActions());
    }

    private IConstructorActionClick getClickListener()
    {
        return (IConstructorActionClick) clickListener;
    }

    @Override
    public void customizeAction(int id)
    {

    }

    @Override
    public void deleteAction(int id)
    {

    }
}