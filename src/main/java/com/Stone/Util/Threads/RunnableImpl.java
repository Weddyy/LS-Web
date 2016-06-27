package com.Stone.Util.Threads;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Wed on 04.02.16.
 */
public abstract class RunnableImpl implements Runnable
{
    public static final Logger _log = LoggerFactory.getLogger(RunnableImpl.class);

    public abstract void runImpl() throws Exception;

    @Override
    public final void run()
    {
        try
        {
            runImpl();
        }
        catch(Exception e)
        {
            _log.error("Exception: RunnableImpl.run(): " + e, e);
        }
    }
}