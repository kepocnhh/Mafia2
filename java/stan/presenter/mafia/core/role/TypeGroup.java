package stan.presenter.mafia.core.role;

        import stan.presenter.mafia.core.MafiaDescription;

public class TypeGroup
        extends MafiaDescription
{
    public boolean visibleInGroup;
    public boolean rang;
    public int rangNum;
    public boolean rangShot;
//    public boolean visibleRang;

    public TypeGroup(String n, String d)
    {
        super(n, d);
    }

    public TypeGroup setVisibleInGroup(boolean vig)
    {
        this.visibleInGroup = vig;
        return this;
    }
    public TypeGroup setRang(boolean r)
    {
        this.rang = r;
        return this;
    }
    public TypeGroup setRangShot(boolean rs)
    {
        this.rangShot = rs;
        return this;
    }
//    public TypeGroup setVisibleRang(boolean vr)
//    {
//        this.visibleRang = vr;
//        return this;
//    }
}