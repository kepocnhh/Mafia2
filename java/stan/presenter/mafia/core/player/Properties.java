package stan.presenter.mafia.core.player;

public class Properties
{
    public boolean life;//состояние здоровья
    public boolean stop;//возможность действовать
    public boolean heal_night;//исцеление ночью
    public boolean heal_day;//исцеление днём
    public Properties()
    {
        clear();
    }
    public void clear()
    {
        this.life = true;
        this.stop = false;
        this.heal_night = false;
        this.heal_day = false;
    }
}