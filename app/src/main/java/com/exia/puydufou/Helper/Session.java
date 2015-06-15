package com.exia.puydufou.Helper;


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

}
