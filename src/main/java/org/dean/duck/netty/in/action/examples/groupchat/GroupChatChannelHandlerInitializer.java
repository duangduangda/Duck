package org.dean.duck.netty.in.action.examples.groupchat;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class GroupChatChannelHandlerInitializer extends ChannelInitializer<SocketChannel> {
	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		ch.pipeline().addLast(new StringDecoder());
		ch.pipeline().addLast(new StringEncoder());
		ch.pipeline().addLast(new GroupChatClientHandler());
	}
}
