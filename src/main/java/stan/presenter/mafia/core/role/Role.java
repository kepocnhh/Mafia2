package stan.presenter.mafia.core.role;

import stan.presenter.mafia.core.MafiaDescription;
import stan.presenter.mafia.core.action.Action;

public class Role
        extends MafiaDescription
{
    public Role[] visibleRoles;
    public Action[] actions;
    public TypeVisibility typeVisibility;
    public TypeGroup typeGroup;
    public Team team;

    public Role(String n, String d)
    {
        super(n, d);
    }

    public Role setTypeVisibility(TypeVisibility tv)
    {
        this.typeVisibility = tv;
        return this;
    }
    public Role setTeam(Team t)
    {
        this.team = t;
        return this;
    }
    public Role setTypeGroup(TypeGroup t)
    {
        this.typeGroup = t;
        return this;
    }
}