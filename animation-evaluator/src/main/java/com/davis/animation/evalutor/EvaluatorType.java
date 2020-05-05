/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2020.05 Davis
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.davis.animation.evalutor;

import com.davis.animation.evalutor.back.BackEaseIn;
import com.davis.animation.evalutor.back.BackEaseInOut;
import com.davis.animation.evalutor.back.BackEaseOut;
import com.davis.animation.evalutor.bounce.BounceEaseIn;
import com.davis.animation.evalutor.bounce.BounceEaseInOut;
import com.davis.animation.evalutor.bounce.BounceEaseOut;
import com.davis.animation.evalutor.circ.CircEaseIn;
import com.davis.animation.evalutor.circ.CircEaseInOut;
import com.davis.animation.evalutor.circ.CircEaseOut;
import com.davis.animation.evalutor.cubic.CubicEaseIn;
import com.davis.animation.evalutor.cubic.CubicEaseInOut;
import com.davis.animation.evalutor.cubic.CubicEaseOut;
import com.davis.animation.evalutor.elastic.ElasticEaseIn;
import com.davis.animation.evalutor.elastic.ElasticEaseOut;
import com.davis.animation.evalutor.expo.ExpoEaseIn;
import com.davis.animation.evalutor.expo.ExpoEaseInOut;
import com.davis.animation.evalutor.expo.ExpoEaseOut;
import com.davis.animation.evalutor.quad.QuadEaseIn;
import com.davis.animation.evalutor.quad.QuadEaseInOut;
import com.davis.animation.evalutor.quad.QuadEaseOut;
import com.davis.animation.evalutor.quint.QuintEaseIn;
import com.davis.animation.evalutor.quint.QuintEaseInOut;
import com.davis.animation.evalutor.quint.QuintEaseOut;
import com.davis.animation.evalutor.sine.SineEaseIn;
import com.davis.animation.evalutor.sine.SineEaseInOut;
import com.davis.animation.evalutor.sine.SineEaseOut;
import com.davis.animation.evalutor.linear.Linear;


public enum EvaluatorType {

    BackEaseIn(BackEaseIn.class),
    BackEaseOut(BackEaseOut.class),
    BackEaseInOut(BackEaseInOut.class),

    BounceEaseIn(BounceEaseIn.class),
    BounceEaseOut(BounceEaseOut.class),
    BounceEaseInOut(BounceEaseInOut.class),

    CircEaseIn(CircEaseIn.class),
    CircEaseOut(CircEaseOut.class),
    CircEaseInOut(CircEaseInOut.class),

    CubicEaseIn(CubicEaseIn.class),
    CubicEaseOut(CubicEaseOut.class),
    CubicEaseInOut(CubicEaseInOut.class),

    ElasticEaseIn(ElasticEaseIn.class),
    ElasticEaseOut(ElasticEaseOut.class),

    ExpoEaseIn(ExpoEaseIn.class),
    ExpoEaseOut(ExpoEaseOut.class),
    ExpoEaseInOut(ExpoEaseInOut.class),

    QuadEaseIn(QuadEaseIn.class),
    QuadEaseOut(QuadEaseOut.class),
    QuadEaseInOut(QuadEaseInOut.class),

    QuintEaseIn(QuintEaseIn.class),
    QuintEaseOut(QuintEaseOut.class),
    QuintEaseInOut(QuintEaseInOut.class),

    SineEaseIn(SineEaseIn.class),
    SineEaseOut(SineEaseOut.class),
    SineEaseInOut(SineEaseInOut.class),

    Linear(Linear.class);


    private Class evaluatorMethod;

    private EvaluatorType(Class clazz) {
        evaluatorMethod = clazz;
    }

    public BaseEvaluatorMethod getMethod(float duration) {
        try {
            return (BaseEvaluatorMethod)evaluatorMethod.getConstructor(float.class).newInstance(duration);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Error("Can not init easingMethod instance");
        }
    }
}
