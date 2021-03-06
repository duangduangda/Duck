package org.dean.duck.netty.in.action.examples.simpletcp.v1;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author eric
 */
//public class SimpleTcpClientHandler extends SimpleChannelInboundHandler<Object> {
public class SimpleTcpClientHandler extends ChannelInboundHandlerAdapter {

	private final static Logger log = LoggerFactory.getLogger(SimpleTcpClientHandler.class);

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		ctx.writeAndFlush(Unpooled.copiedBuffer("Hello,Server.", CharsetUtil.UTF_8));
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		ByteBuf byteBuf = (ByteBuf) msg;
		log.info("from server:" + byteBuf.toString(CharsetUtil.UTF_8));
		log.info("server address:" + ctx.channel().remoteAddress());

	}

//	@Override
//	protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
//		ByteBuf byteBuf = (ByteBuf) msg;
//		log.info("from server:" + byteBuf.toString(CharsetUtil.UTF_8));
//		log.info("server address:" + ctx.channel().remoteAddress());
//	}


	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}
}
