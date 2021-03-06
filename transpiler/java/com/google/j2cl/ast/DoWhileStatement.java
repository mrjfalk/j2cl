/*
 * Copyright 2015 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.j2cl.ast;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.j2cl.ast.annotations.Visitable;
import com.google.j2cl.common.SourcePosition;

/** DoWhile Statement. */
@Visitable
public class DoWhileStatement extends Statement {
  @Visitable Expression conditionExpression;
  @Visitable Statement body;

  public DoWhileStatement(
      SourcePosition sourcePosition, Expression conditionExpression, Statement body) {
    super(sourcePosition);
    this.conditionExpression = checkNotNull(conditionExpression);
    this.body = checkNotNull(body);
  }

  public Expression getConditionExpression() {
    return conditionExpression;
  }

  public Statement getBody() {
    return body;
  }

  @Override
  public DoWhileStatement clone() {
    return new DoWhileStatement(
        getSourcePosition(), conditionExpression.clone(), AstUtils.clone(body));
  }

  @Override
  public Node accept(Processor processor) {
    return Visitor_DoWhileStatement.visit(processor, this);
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  /** A Builder for DoWhileStatement. */
  public static class Builder {
    private Expression conditionExpression;
    private Statement body;
    private SourcePosition sourcePosition;

    public static Builder from(DoWhileStatement doWhileStatement) {
      return new Builder()
          .setSourcePosition(doWhileStatement.getSourcePosition())
          .setConditionExpression(doWhileStatement.getConditionExpression())
          .setBody(doWhileStatement.getBody());
    }

    public Builder setSourcePosition(SourcePosition sourcePosition) {
      this.sourcePosition = sourcePosition;
      return this;
    }

    public Builder setConditionExpression(Expression conditionExpression) {
      this.conditionExpression = conditionExpression;
      return this;
    }

    public Builder setBody(Statement body) {
      this.body = body;
      return this;
    }

    public DoWhileStatement build() {
      return new DoWhileStatement(sourcePosition, conditionExpression, body);
    }
  }
}
