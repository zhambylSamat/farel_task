package decathlon;

public class Score {

    private Double m_100;
    private Double long_jump;
    private Double shot_put;
    private Double high_jump;
    private Double m_400;
    private Double hurdles_110m;
    private Double discus_throw;
    private Double pole_vault;
    private Double javelin_throw;
    private Double m_1500;

    public Score(Double m_100, Double long_jump, Double shot_put, Double high_jump, Double m_400, Double hurdles_110m,
                 Double discus_throw, Double pole_vault, Double javelin_throw, Double m_1500) {
        this.m_100 = m_100;
        this.long_jump = long_jump;
        this.shot_put = shot_put;
        this.high_jump = high_jump;
        this.m_400 = m_400;
        this.hurdles_110m = hurdles_110m;
        this.discus_throw = discus_throw;
        this.pole_vault = pole_vault;
        this.javelin_throw = javelin_throw;
        this.m_1500 = m_1500;
    }

    public void setM_100(Double m_100) {
        this.m_100 = m_100;
    }

    public Double getM_100() {
        return this.m_100;
    }

    public void setLong_jump(Double long_jump) {
        this.long_jump = long_jump;
    }

    public Double getLong_jump() {
        return this.long_jump;
    }

    public void setShot_put(Double shot_put) {
        this.shot_put = shot_put;
    }

    public Double getShot_put() {
        return this.shot_put;
    }

    public void setHigh_jump(Double high_jump) {
        this.high_jump = high_jump;
    }

    public Double getHigh_jump() {
        return this.high_jump;
    }

    public void setM_400(Double m_400) {
        this.m_400 = m_400;
    }

    public Double getM_400() {
        return this.m_400;
    }

    public void setHurdles_110m(Double hurdles_110m) {
        this.hurdles_110m = hurdles_110m;
    }

    public Double getHurdles_110m() {
        return this.hurdles_110m;
    }

    public void setDiscus_throw(Double discus_throw) {
        this.discus_throw = discus_throw;
    }

    public Double getDiscus_throw() {
        return this.discus_throw;
    }

    public void setPole_vault(Double pole_vault) {
        this.pole_vault = pole_vault;
    }

    public Double getPole_vault() {
        return this.pole_vault;
    }

    public void setJavelin_throw(Double javelin_throw) {
        this.javelin_throw = javelin_throw;
    }

    public Double getJavelin_throw() {
        return this.javelin_throw;
    }

    public void setM_1500(Double m_1500) {
        this.m_1500 = m_1500;
    }

    public Double getM_1500() {
        return this.m_1500;
    }
}
