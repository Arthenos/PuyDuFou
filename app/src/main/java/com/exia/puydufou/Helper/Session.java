package com.exia.puydufou.Helper;


import com.exia.puydufou.BusinessObject.SpectacleBU;

import java.util.List;

public final class Session
{
    private Session() {}

    /** Holder */
    private static class SessionHolder
    {
        /** Instance unique non préinitialisée */
        private final static Session instance = new Session();
    }

    /** Point d'accès pour l'instance unique du singleton */
    public static Session Instance()
    {
        return SessionHolder.instance;
    }



    //FIELDS
    private List<SpectacleBU> _planning = null;

    public List<SpectacleBU> GetPlanning()
    {
        return _planning;
    }

    public void SetPlanning(List<SpectacleBU> _planning)
    {
        this._planning = _planning;
    }

}
