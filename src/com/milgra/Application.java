package com.milgra;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.red5.server.api.IConnection;
import org.red5.server.adapter.ApplicationAdapter;

public class Application extends ApplicationAdapter
{
    private static final Log log = LogFactory.getLog( Application.class );

    public boolean appStart ( )
    {
        log.info( "Red5First.appStart" );
        return true;
    }

    public void appStop ( )
    {
        log.info( "Red5First.appStop" );
    }

    public boolean appConnect( IConnection conn , Object[] params )
    {
        log.info( "Red5First.appConnect " + conn.getClient().getId() );

        boolean accept = (Boolean)params[0];

        if ( !accept ) rejectClient( "you passed false..." );

        return true;
    }

    public void appDisconnect( IConnection conn)
    {
        log.info( "Red5First.appDisconnect " + conn.getClient().getId() );
       super.appDisconnect(conn);
    }
    
}
