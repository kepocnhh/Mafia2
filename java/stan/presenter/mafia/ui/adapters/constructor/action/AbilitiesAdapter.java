package stan.presenter.mafia.ui.adapters.constructor.action;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import stan.presenter.mafia.R;
import stan.presenter.mafia.core.abilities.Ability;
import stan.presenter.mafia.ui.holders.adapters.constructor.action.AbilitiesHolder;

public class AbilitiesAdapter
        extends RecyclerView.Adapter<AbilitiesHolder>
{
    private Context mContext;
    private List<Ability> abilities;

    public AbilitiesAdapter(Context context, List<Ability> a)
    {
        mContext = context;
        abilities = a;
    }

    @Override
    public AbilitiesHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v = inflater.inflate(R.layout.constructor_action_result_abilities_list_item, parent, false);
        return new AbilitiesHolder(v);
    }

    @Override
    public void onBindViewHolder(AbilitiesHolder holder, int position)
    {

    }

    @Override
    public long getItemId(int position)
    {
        return abilities.get(position).UID;
    }
    @Override
    public int getItemCount()
    {
        return abilities.size();
    }
}