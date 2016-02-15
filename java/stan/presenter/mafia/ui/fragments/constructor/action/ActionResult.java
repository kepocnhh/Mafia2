package stan.presenter.mafia.ui.fragments.constructor.action;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import stan.presenter.mafia.R;
import stan.presenter.mafia.listeners.fragments.constructor.action.IActionResultClick;
import stan.presenter.mafia.ui.adapters.constructor.action.AbilitiesAdapter;
import stan.presenter.mafia.ui.fragments.StanFragment;

public class ActionResult
        extends StanFragment
{
    //_______________VIEWS
    TextView nameAction;
    TextView descriptionAction;
    RecyclerView listAbilities;

    //_______________FIELDS
    private AbilitiesAdapter adapter;

    static public ActionResult newInstance()
    {
        ActionResult fragment = new ActionResult();
        Bundle args = fragment.getArguments();
        fragment.setArguments(args);
        return fragment;
    }

    public ActionResult()
    {
        super(R.layout.constructor_action_result, R.string.ActionResult);
    }

    @Override
    protected void findViews(View v)
    {
        super.findViews(v);
        nameAction = (TextView) v.findViewById(R.id.nameAction);
        descriptionAction = (TextView) v.findViewById(R.id.descriptionAction);
        listAbilities = (RecyclerView) v.findViewById(R.id.listAbilities);
        initList();
        init();
    }

    private void initList()
    {
    }

    private void init()
    {

    }

    private IActionResultClick getClickListener()
    {
        return (IActionResultClick) clickListener;
    }
}