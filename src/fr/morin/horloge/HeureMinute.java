package fr.morin.horloge;

public class HeureMinute {
    private byte heure = 0;
    private byte minute = 0;


    public HeureMinute(byte heure ,byte minute) throws Exception {
        this.setHeure(heure);
        this.setMinute(minute);
    }
    public HeureMinute() throws Exception {
        this((byte)java.time.LocalTime.now().getHour(),(byte)java.time.LocalTime.now().getMinute());
    }

    public int getHeure() {
        return heure;
    }

    public void setHeure(int heure) throws Exception {
        if (heure<0 || heure>23){
            //throw new IllegalArgumentException("Les heures indiquées ne sont pas comprise entre 0 et 59");
            throw new Exception("Les heures indiquées ne sont pas comprise entre 0 et 59");
        } else {
            this.heure = (byte)heure;
        }
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) throws Exception {
        if (minute<0 || minute>59){
            //throw new IllegalArgumentException("Les minutes indiquées ne sont pas comprise entre 0 et 59");
            throw new Exception("Les minutes indiquées ne sont pas comprise entre 0 et 59");
        } else {
            this.minute = (byte)minute;
        }
    }

    public void setHeureMinute (int heure, int minute) throws Exception {
        this.setHeure(heure);
        this.setMinute(minute);
    }

    public String toString(){
        return getHeure() + ":" + getMinute();
    }

    public void avancerMinute (int minute){
            int totalMinutes = this.heure * 60 + this.minute + minute;
            int minutesRemappees = 0;
            if (totalMinutes < 0) {
                minutesRemappees = (1440+totalMinutes)% 1440; // 1440 minutes dans un jour
            }
            else {
                minutesRemappees = totalMinutes% 1440; // 1440 minutes dans un jour
            }
            this.heure = (byte) (minutesRemappees / 60);
            this.minute = (byte) (minutesRemappees % 60);
        /*this.minute = (byte) (this.minute+minute);
        if (this.getMinute()>59){
            this.minute = (byte) (this.minute-60);
            if (this.getHeure()==23){
                this.heure = 0;
            } else {
                this.heure = (byte) (this.heure+1);
            }
        } else if (this.getMinute()<0) {
            this.minute = (byte) (this.minute+60);
            if (this.getHeure()==0){
                this.heure = 23;
            } else {
                this.heure = (byte) (this.heure-1);
            }
        }*/
    }
}
