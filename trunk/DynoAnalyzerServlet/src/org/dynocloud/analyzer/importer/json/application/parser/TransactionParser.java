package org.dynocloud.analyzer.importer.json.application.parser;

class TransactionParser extends AbstractEdgeParser{
	
	static{
		AbstractParser.register(StencilTypes.TRANSACTION, new TransactionParser());
	}
	
	private TransactionParser(){
		
	}

}
