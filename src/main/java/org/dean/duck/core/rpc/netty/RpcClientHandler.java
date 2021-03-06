package org.dean.duck.core.rpc.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.dean.duck.core.rpc.netty.protocol.RpcRequest;
import org.dean.duck.core.rpc.netty.protocol.RpcResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

/**
 * Title. <br> Description.
 * <p>
 * Copyright: Copyright (c) 2018/9/4
 * <p>
 * Company:
 * <p>
 *
 * @author: eric
 * <p>
 * Version: 1.0
 * <p>
 */
public class RpcClientHandler extends SimpleChannelInboundHandler<RpcResponse> {

	private static final Logger logger = LoggerFactory.getLogger(RpcClientHandler.class);

	@Override
	protected void channelRead0(ChannelHandlerContext channelHandlerContext, RpcResponse rpcResponse) throws Exception {
		logger.info("Request:" + rpcResponse.getRequestId() + " receive result from data is " + rpcResponse.getResult());
		channelHandlerContext.flush();
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		RpcRequest request = new RpcRequest().
				setRequestId(UUID.randomUUID().toString())
				.setMethodName("sayHello")
				.setClassName("com.smallhk.core.rpc.oio.server.api.HelloServiceImpl")
				.setParameters(new Object[]{"eric dong"})
				.setParameterTypes(new Class[]{String.class});
		ctx.writeAndFlush(request);
	}
}
